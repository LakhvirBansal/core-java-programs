package Synchronization;

import java.util.ArrayList;
import java.util.List;

class Meeting {

	private int startTime;

	private int endTime;

	Meeting() {
		super();
	}

	Meeting(int val1, int val2) {
		startTime = val1;
		endTime = val2;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Meeting [startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}

public class Test {

	public static void main(String[] args) {
		Meeting t1 = new Meeting(0, 1);
		Meeting t2 = new Meeting(3, 5);

		Meeting t3 = new Meeting(4, 8);
		Meeting t4 = new Meeting(10, 12);
		Meeting t5 = new Meeting(9, 10);

		List<Meeting> timings = new ArrayList<Meeting>();
		timings.add(t1);
		timings.add(t2);

		timings.add(t3);
		timings.add(t4);
		timings.add(t5);

		Test t = new Test();
		List<Meeting> mergeRanges = t.mergeRanges(timings);

		for (Meeting timing : mergeRanges) {
			System.out.println(timing);
		}

	}

	/**
	 * used to merge ranges.
	 * 
	 * @param timings
	 *            timings
	 * @return List<meetings>
	 */
	public List<Meeting> mergeRanges(List<Meeting> timings) {

		List<Meeting> ranges = new ArrayList<Meeting>();

		for (Meeting timing : timings) {

			if (ranges.isEmpty()) { // in starting we need to create first object
				createMeetingObject(ranges, timing);
			} else {

				boolean isPresent = false;
				for (Meeting range : ranges) {

					// check start time in range
					if (range.getStartTime() < timing.getStartTime() && range.getEndTime() >= timing.getStartTime()) {
						isPresent = true;
						if (timing.getEndTime() > range.getEndTime()) {
							range.setEndTime(timing.getEndTime());
						}
					} else if (range.getStartTime() <= timing.getEndTime() && range.getEndTime() > timing.getEndTime()) {
						isPresent = true;
						if (timing.getStartTime() < range.getStartTime()) {
							range.setStartTime(timing.getStartTime());
						}
					} else if (range.getStartTime() > timing.getStartTime()
							&& range.getEndTime() < timing.getEndTime()) {
						isPresent = true;
						range.setStartTime(timing.getStartTime());
						range.setEndTime(timing.getEndTime());

					}

				}
				if (!isPresent) {// create new meeting object
					createMeetingObject(ranges, timing);
				}
			}

		}

		return ranges;
	}

	/**
	 * used to create meeting object and add to list.
	 * 
	 * @param ranges
	 *            ranges
	 * @param timing
	 *            timing
	 */
	private static void createMeetingObject(List<Meeting> ranges, Meeting timing) {
		Meeting meeting = new Meeting();
		meeting.setStartTime(timing.getStartTime());
		meeting.setEndTime(timing.getEndTime());
		ranges.add(meeting);

	}

}
