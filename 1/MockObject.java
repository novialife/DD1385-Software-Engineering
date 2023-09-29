package labb2;

public class MockObject implements Boardgame {

	public boolean move(int i, int j) {
		System.out.println("Moves something");
		return false;
	}

	public String getStatus(int i, int j) {
		// System.out.println("Returns content of something");
		return "foo";
	}

	public String getMessage() {
		// System.out.println("Returns status of something");
		return "foo";
	}

}
