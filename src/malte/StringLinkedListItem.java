/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte;

/**
 *
 * @author malte
 */
public class StringLinkedListItem {
  private String data;
  private StringLinkedListItem next;
  private StringLinkedListItem prev;
  
  public StringLinkedListItem(String string) {
    this.data = string;
  }
  
  public String toString() {
    return data;
  }

  public void setString(String data) {
    this.data = data;
  }

  public StringLinkedListItem next() {
    return next;
  }

  public void setNext(StringLinkedListItem next) {
    this.next = next;
  }

  public StringLinkedListItem prev() {
    return prev;
  }

  public void setPrev(StringLinkedListItem prev) {
    this.prev = prev;
  }
  
}
