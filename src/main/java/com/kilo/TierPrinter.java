package com.kilo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class TierPrinter {

    <T> List<List<T>> getTiers(Map<T, List<T>> inputMap) {
        Map<T, Integer> nodeToLevelMap = new HashMap<>();
        Set<T> unvisitedNodes = inputMap.keySet();
        while(!unvisitedNodes.isEmpty()) {
            Set<T> nextUnvisitedNodes = new HashSet<>();
            for (T node : unvisitedNodes) {
                List<T> deps = inputMap.get(node);
                if (deps.isEmpty()) {
                    // This is the min level
                    nodeToLevelMap.put(node, 1);
                    nextUnvisitedNodes.remove(node);
                } else {
                    int maxLevel = Integer.MIN_VALUE;
                    boolean maxChanged = false;
                    // Find the level of the dependencies
                    for (T dep : deps) {
                        if (nodeToLevelMap.containsKey(dep)) {
                            int depLevel = nodeToLevelMap.get(dep);
                            if (maxLevel < depLevel) {
                                maxLevel = depLevel;
                                maxChanged = true;
                            }
                        } else {
                            nextUnvisitedNodes.add(dep);
                        }
                    }
                    if(maxChanged) {
                        nodeToLevelMap.put(node, maxLevel + 1);
                    } else {
                        nextUnvisitedNodes.add(node);
                    }
                }
            }
            unvisitedNodes = nextUnvisitedNodes;
        }

        Map<Integer, List<T>> levelToNodeMap = new TreeMap<>();
        for(Map.Entry<T, Integer> entry: nodeToLevelMap.entrySet()) {
            Integer level = entry.getValue();
            List<T> existingNodes = levelToNodeMap.computeIfAbsent(level, k -> new ArrayList<>());
            existingNodes.add(entry.getKey());
        }
        return new ArrayList<>(levelToNodeMap.values());
    }

}
