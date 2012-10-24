package util;

import java.util.ArrayList;
import java.util.List;

public class Factory {
	public static <T> List<T> createList() {
		return new ArrayList<T> ();
	}

}
