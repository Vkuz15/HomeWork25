package org.example;

import org.example.exception.InvalidIndexException;
import org.example.exception.NullPointerItemException;
import org.example.exception.StorageIsFullException;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private final String[] storage;
    private int size;

    public StringListImpl() {
        storage = new String[10];
    }

    public StringListImpl(int initSize) {
        storage = new String[initSize];
    }
    private void validateItem(String item) {
        if (item == null) {
            throw new NullPointerItemException();
        }
    }
    private void validateSize() {
        if (size == storage.length) {
            throw new StorageIsFullException();
        }
    }
    private void validateIndex(int index) {
        if (index >= size) {
            throw new InvalidIndexException();
        }
    }

    public String add(String item) {
        validateItem(item);
        validateSize();
        storage[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateItem(item);
        if (index == size) {
            storage[size++] = item;
            return item;
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        item = storage[index];
        return item;
    }
    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }
    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = storage[index];
        if (index != size) {
            System.arraycopy(storage, index + 1, storage, index, size - (index + 1));
        }
        return item;
    }
    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }
    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public String get(int index) {
        return storage[index];
    }
    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public void clear() {
        size = 0;
    }
    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage, size);
    }
}

