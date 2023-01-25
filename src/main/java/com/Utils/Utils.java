package com.Utils;

import java.io.IOException;

import com.BaseClass.BaseClass;

public class Utils extends BaseClass {

	public Utils() throws IOException {
		super();

	}

	public void switchToFrame() {

		driver.switchTo().frame("mainpanel");

	}

}
