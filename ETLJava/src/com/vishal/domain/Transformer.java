package com.vishal.domain;

import java.io.IOException;

public interface Transformer {

	public void Transform() throws IOException;
	public void load();

}
class HelloWorld
{
    // Your program begins with a call to main().
    // Prints "Hello, World" to the terminal window.
    public static void main(String args[])
    {
        System.out.println("Hello, World");
    }
}
