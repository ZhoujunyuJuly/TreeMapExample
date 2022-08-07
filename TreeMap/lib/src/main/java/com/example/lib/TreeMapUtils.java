package com.example.lib;

import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapUtils<K,V> {
    private TreeMap<K,V> mTreeMap;

    public TreeMapUtils(TreeMap treeMap) {
        mTreeMap = treeMap;
    }

    public void put(K key,V value){
        mTreeMap.put(key,value);
    }

    public Set<Map.Entry<K, V>> entrySet(){
        return mTreeMap.entrySet();
    }
    /**
     * 返回小于key的第一个元素：
     * @param key
     */
    public Map.Entry<K,V> lowerEntry(K key){
        return mTreeMap.lowerEntry(key);
    }


    /**
     * 返回小于key的第一个键：
     * @param key
     */
    public K lowerKey(K key){
        return mTreeMap.lowerKey(key);
    }

    /**
     * 返回小于等于key的第一个键：
     * @param key
     * @return
     */
    public K floorKey(K key){
        return mTreeMap.floorKey(key);
    }

    /**
     * 返回大于或者等于key的第一个元素：
     * @param key
     * @return
     */
    public Map.Entry<K,V> ceilingEntry(K key){
        return mTreeMap.ceilingEntry(key);
    }


    /**
     * 返回大于或者等于key的第一个元素：
     * @param key
     * @return
     */
    public K ceilingKey(K key){
        return mTreeMap.ceilingKey(key);
    }
    /***
     * 返回大于key的第一个元素：
     * @param key
     * @return
     */
    public Map.Entry<K,V> higherEntry(K key){
        return mTreeMap.higherEntry(key);
    }

    /**
     * 返回大于key的第一个键：
     * @param key
     * @return
     */
    public K higherKey(K key){
        return mTreeMap.higherKey(key);
    }

    /**
     * 返回集合中第一个元素：
     * @return
     */
    public Map.Entry<K,V> firstEntry(){
        return mTreeMap.firstEntry();
    }


    /**
     * 返回集合中最后一个元素：
     * @return
     */
    public Map.Entry<K,V> lastEntry(){
        return mTreeMap.lastEntry();
    }

    /**
     * 返回集合中第一个元素，并从集合中删除：
     * @return
     */
    public Map.Entry<K,V> pollFirstEntry(){
        return mTreeMap.pollFirstEntry();
    }

    /**
     * 返回集合中最后一个元素，并从集合中删除：
     * @return
     */
    public Map.Entry<K,V> pollLastEntry(){
        return mTreeMap.pollLastEntry();
    }

    /**
     * 返回倒序的Map集合：
     * @return
     */
    public NavigableMap<K,V> descendingMap(){
        return mTreeMap.descendingMap();
    }

    public NavigableSet<K> navigableKeySet(){
        return mTreeMap.navigableKeySet();
    }

    /**
     * 返回Map集合中倒序的Key组成的Set集合：
     * @return
     */
    public NavigableSet<K> descendingKeySet(){
        return mTreeMap.descendingKeySet();
    }

    public NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive,
                                       K toKey, boolean toInclusive){
        return mTreeMap.subMap(fromKey,fromInclusive,toKey,toInclusive);
    }

    public NavigableMap<K,V> headMap(K toKey, boolean inclusive){
        return mTreeMap.headMap(toKey,inclusive);
    }

    public NavigableMap<K,V> tailMap(K fromKey, boolean inclusive){
        return mTreeMap.tailMap(fromKey,inclusive);
    }

    public SortedMap<K,V> subMap(K fromKey, K toKey){
        return mTreeMap.subMap(fromKey,toKey);
    }

    public SortedMap<K,V> headMap(K toKey){
        return mTreeMap.headMap(toKey);
    }

    public SortedMap<K,V> tailMap(K fromKey){
        return mTreeMap.tailMap(fromKey);
    }
}
