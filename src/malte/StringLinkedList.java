/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte;

import jdk.jshell.spi.ExecutionControl;

/**
 *
 * @author malte
 */
public class StringLinkedList implements StringList {
  private int size;
  private StringLinkedListItem first;
  
  public StringLinkedList() {
    this.size = 0;
  }
  
  @Override
  public void add(String value) {
    if(this.first == null) {
      this.first = new StringLinkedListItem(value);
    } else {
      StringLinkedListItem currentNode = this.first;
      while(currentNode.next() != null) {
        currentNode = currentNode.next();
      }
      
      StringLinkedListItem newItem = new StringLinkedListItem(value);
      newItem.setPrev(currentNode);      
      currentNode.setNext(newItem);
    }
    
    this.size++;
  }

  @Override
  public void add(int index, String value) {
    // Falls die Position überhaupt existiert
    if(index > size) {
      throw new ArrayIndexOutOfBoundsException(index);
    }

    StringLinkedListItem newItem = new StringLinkedListItem(value);
    // Falls kein erstes element existiert, annahme dass index = 0
    if(this.first == null) {
      add(value);
      
    // Falls erstes Element existiert, aber trotzdem an erster Stelle eingefügt
    // werden soll
    } else if (index == 0) {
      this.first.setPrev(newItem);
      newItem.setNext(this.first);
      this.first = newItem;
      this.size++;
    } else {
      int currentIndex = 0;
      StringLinkedListItem currentItem = this.first;
      while(currentIndex < index-1) {
        currentItem = currentItem.next();
        currentIndex++;
      }
      
      newItem.setPrev(currentItem);
      
      // Falls ein nachfolgendes Element existiert
      if(currentItem.next() != null) {
        newItem.setNext(currentItem.next());
        currentItem.next().setPrev(newItem);
      }
      currentItem.setNext(newItem);
      this.size++;
    }
  }

  @Override
  public boolean contains(String value) {
    if(this.size > 0) {
      StringLinkedListItem currentItem = this.first;
      while(currentItem != null) {

        if(currentItem.toString().equals(value)) {
          return true;
        }
        currentItem = currentItem.next();
      }
    }
    return false;
  }

  @Override
  public int indexOf(String value) {
     if(this.size > 0) {
      StringLinkedListItem currentItem = this.first;
      int currentIndex = 0;
      
      while(currentItem != null) {
        if(currentItem.toString().equals(value)) {
          return currentIndex;
        }
        currentIndex++;
        currentItem = currentItem.next();
      }
    }
    return -1;
  }

  @Override
  public boolean remove(String value) {
    if(this.first == null) {
      return false;
    }
    
    if(this.first.toString().equals(value)) {
      if(this.first.next() != null) {
        this.first.next().setPrev(null);
      }
      
      this.first = this.first.next();
      this.size --;
      return true;
    }
    
    StringLinkedListItem currentItem = this.first.next();
    while(currentItem != null) {
      if(currentItem.toString().equals(value)) {
        currentItem.prev().setNext(currentItem.next());
        currentItem.next().setPrev(currentItem.prev());
        return true;
      }
    }
    return false;
  }

  @Override
  public String remove(int index) {
    if(index > this.size) {
      throw new ArrayIndexOutOfBoundsException();
    }
    if(index == 0) {
      String text = this.first.toString();
      if(this.first.next() != null) {
        this.first.next().setPrev(null);
        this.first = this.first.next();
      }
      this.size--;
      return text;
    }
     StringLinkedListItem currentItem = this.first;
      int currentIndex = 0;
      
      while(currentIndex < index) {
        currentIndex++;
        currentItem = currentItem.next();
      }
     
      if(currentItem.next() != null) {
        currentItem.next().setPrev(currentItem.prev());
      }
      currentItem.prev().setNext(currentItem.next());
      
      this.size--;
      return currentItem.toString();
  }

  @Override
  public String get(int index) {
    if(index > size) {
      throw new IndexOutOfBoundsException();
    }

    StringLinkedListItem currentItem = this.first;
    int currentIndex = 0;
    
    while(currentIndex < index) {
      currentItem = currentItem.next();
      currentIndex++;
    }
    
    return currentItem.toString();
  }

  @Override
  public int size() {
    return this.size;
  }
  
}
