package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {
    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = new LinkedHashMap<>();
    }

    public PhoneBook() {
        this(null);
    }

    public void add(String name, String phoneNumber) {
        phonebook.put(name, Collections.singletonList(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.put(name, List.of(phoneNumbers));
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public Boolean hasEntry(String name, String phoneNumbers) {
        List<String> phoneList = phonebook.get(name);

        if (phoneList.contains(phoneNumbers)) {
            return true;
        }
        return false;
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber) {
        for(Map.Entry<String, List<String>> entry : phonebook.entrySet()){
            List<String> numbers = entry.getValue();
            if(numbers.contains(phoneNumber)){
                return entry.getKey();
            }
        }
        return null;
    }


    public List<String> getAllContactNames() {
        List<String> namesOnly = new ArrayList<>(phonebook.keySet());
        return namesOnly;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
