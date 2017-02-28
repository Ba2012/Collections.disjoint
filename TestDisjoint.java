import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Bryce
 * @version 1.0 This class tests the method Collections.disjoint();
 * 
 *
 */
public class TestDisjoint {
	
	Collection<Object> collection1;
	Collection<Object> collection2;
	Object[] arrayIntegers = new Object[10];
	Object[] arrayStrings = new Object[10];
	Object[] arrayNulls = new Object[10];

	@Before
	public void setUp() throws Exception {
		collection1 = new ArrayList<Object>();
		collection2 = new ArrayList<Object>();
		for (int i = 0; i < arrayIntegers.length; i++) {
			arrayIntegers[i] = new Integer(i);
			arrayStrings[i] = new Integer(arrayIntegers.length + i);
			arrayNulls[i] = null;
		}
	}

	@Test
	public void testDisjoint_ArrayListWithNoCommonElement_True() {
		Collections.addAll(collection1, arrayIntegers);
		Collections.addAll(collection2, arrayStrings);
		assertTrue(Collections.disjoint(collection1, collection2));
	}

	@Test
	public void testDisjoint_ArrayListWithAtLeastOneCommonElement_False() {
		Collections.addAll(collection1, arrayIntegers);
		Collections.addAll(collection2, arrayStrings);
		Collections.addAll(collection2, (new Integer(1)));
		assertFalse(Collections.disjoint(collection1, collection2));
	}

	@Test
	public void testDisjoint_LinkedListWithNoCommonElement_True() {
		collection1 = new LinkedList<Object>();
		collection2 = new LinkedList<Object>();
		Collections.addAll(collection1, arrayIntegers);
		Collections.addAll(collection2, arrayStrings);
		assertTrue(Collections.disjoint(collection1, collection2));
	}

	@Test
	public void testDisjoint_LinkedListWithCommonElement_False() {
		Collections.addAll(collection1, arrayIntegers);
		Collections.addAll(collection2, arrayStrings);
		Collections.addAll(collection2, (new Integer(1)));
		assertFalse(Collections.disjoint(collection1, collection2));
	}

	@Test
	public void testDisjoint_theSameLinkedListWithNoElements_True() {
		collection1 = new LinkedList<Object>();
		assertTrue(Collections.disjoint(collection1, collection1));

	}

	@Test
	public void TestDisjoint_SameLinkedListWithElements_False() {
		collection1 = new LinkedList<Object>();
		Collections.addAll(collection1, arrayIntegers);
		assertFalse(Collections.disjoint(collection1, collection1));

	}

	@Test(expected = NullPointerException.class)
	public void TestDisjoint_NullCollection() {
		collection1 = null;
		Collections.disjoint(collection1, collection2);

	}

	@Test
	public void testDisjoint_DifferentCollectionTypes_True() {
		collection1 = new LinkedList<Object>();
		collection2 = new TreeSet<Object>();
		Collections.addAll(collection1, arrayIntegers);
		Collections.addAll(collection2, arrayStrings);
		assertTrue(Collections.disjoint(collection2, collection1));
	}

	@Test(expected = NullPointerException.class)
	public void testDisjoint_NullValuesNotAccepted() {
		collection1 = new TreeSet<Object>();
		collection2 = new LinkedList<Object>();
		Collections.addAll(collection1, arrayIntegers);
		Collections.addAll(collection2, arrayNulls);
		Collections.disjoint(collection1, collection2);

	}

}
