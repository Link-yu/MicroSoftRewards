package com.example.microsoftrewards.entry;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class TreeNode implements Serializable {
   private static final long serialVersionUID = 1L;
   String title = " ";
   String value = " ";
   Integer leaf = 0;
   List<TreeNode> children;

   public String getTitle() {
      if (this.title == null) {
         return " ";
      } else {
         return this.title.isEmpty() ? " " : this.title;
      }
   }

   public String getValue() {
      if (this.value == null) {
         return " ";
      } else {
         return this.value.isEmpty() ? " " : this.value;
      }
   }

   public Integer getLeaf() {
      return this.leaf != null ? this.leaf : 0;
   }

   public List<TreeNode> getChildren() {
      return this.children;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public void setValue(String value) {
      this.value = value;
   }

   public void setLeaf(Integer leaf) {
      this.leaf = leaf;
   }

   public void setChildren(List<TreeNode> children) {
      this.children = children;
   }

   public String toString() {
      StringBuffer buffer = new StringBuffer();
      buffer.append("TreeNode:(");
      buffer.append("title:" + this.title);
      buffer.append(",value:" + this.value);
      buffer.append(",leaf:" + this.leaf);
      buffer.append(",children:" + this.children);
      buffer.append(")");
      return buffer.toString();
   }

   public int hashCode() {
      HashCodeBuilder builder = new HashCodeBuilder();
      builder.append(this.title);
      builder.append(this.value);
      builder.append(this.leaf);
      builder.append(this.children);
      return builder.toHashCode();
   }

   public boolean equals(Object obj) {
      if (obj instanceof TreeNode) {
         TreeNode test = (TreeNode)obj;
         EqualsBuilder builder = new EqualsBuilder();
         builder.append(this.title, test.title);
         builder.append(this.value, test.value);
         builder.append(this.leaf, test.leaf);
         builder.append(this.children, test.children);
         return builder.isEquals();
      } else {
         return false;
      }
   }
}
