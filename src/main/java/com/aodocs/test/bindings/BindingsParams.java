/**
 * 
 */
package com.aodocs.test.bindings;

/**
 * @author Xavier Guillon
 *
 */
public class BindingsParams {
	/** */
	private Bindings b;

	private Object[] args;

	private BindingsParams child;

	public BindingsParams(Bindings b, Object... args) {
		this.b = b;
		this.args = args;
	}

	public BindingsParams(BindingsParams parent, BindingsParams child) {
		this(parent.getB(), parent.getArgs());
		this.child = child;
	}

	public Bindings getB() {
		return b;
	}

	public void setB(Bindings b) {
		this.b = b;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	public BindingsParams getChild() {
		return child;
	}

	public void setChild(BindingsParams child) {
		this.child = child;
	}
}
