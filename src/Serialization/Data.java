package Serialization;

import java.io.Serializable;

public class Data implements Serializable {

	transient int i = 10;
	int j = 20;

}
