package com.nb.main;

public class MyModel {
 private String str1;
 private int x;
public String getStr1() {
	return str1;
}
public void setStr1(String str1) {
	this.str1 = str1;
}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((str1 == null) ? 0 : str1.hashCode());
	result = prime * result + x;
	return result;
}
@Override
public boolean equals(Object obj) {
	MyModel other = (MyModel) obj;
	if (str1 == null) {
		if (other.str1 != null)
			return false;
	} else if (!str1.equals(other.str1))
		return false;
	if (x != other.x)
		return false;
	return true;
}


 
}
