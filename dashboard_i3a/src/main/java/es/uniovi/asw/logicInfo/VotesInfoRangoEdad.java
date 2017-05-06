package es.uniovi.asw.logicInfo;

import java.util.List;

import es.uniovi.asw.domain.Vote;
import es.uniovi.asw.domain.VoteProposal;
import es.uniovi.asw.util.AgeCalculator;

public class VotesInfoRangoEdad extends VotesInformation {

	/**
	 * Young = 18-30 Adult = 30-55 Old = 55 ->>
	 */

	private int youngNumberYes;
	private int adultNumberYes;
	private int oldNumberYes;
	private int youngNumberNo;
	private int adultNumberNo;
	private int oldNumberNo;
	private double youngPerYes;
	private double oldPerYes;
	private double adultgPerYes;
	private double youngPerNo;
	private double oldPerNo;
	private double adultgPerNo;

	private int youngVotes;
	private int adultVotes;
	private int oldVotes;

	public VotesInfoRangoEdad(List<VoteProposal> list) {
		super(list);
		setMoreInfo();
	}

	public int getYoungNumberYes() {
		return youngNumberYes;
	}

	public int getAdultNumberYes() {
		return adultNumberYes;
	}

	public int getOldNumberYes() {
		return oldNumberYes;
	}

	public int getYoungNumberNo() {
		return youngNumberNo;
	}

	public int getAdultNumberNo() {
		return adultNumberNo;
	}

	public int getOldNumberNo() {
		return oldNumberNo;
	}

	public int getYoungPerYes() {
		return (int) youngPerYes;
	}

	public int getOldPerYes() {
		return (int) oldPerYes;
	}

	public int getAdultgPerYes() {
		return (int) adultgPerYes;
	}

	public int getYoungPerNo() {
		return (int) youngPerNo;
	}

	public int getOldPerNo() {
		return (int) oldPerNo;
	}

	public int getAdultgPerNo() {
		return (int) adultgPerNo;
	}

	public int getYoungVotes() {
		return youngVotes;
	}

	public void setYoungVotes(int youngVotes) {
		this.youngVotes = youngVotes;
	}

	public int getAdultVotes() {
		return adultVotes;
	}

	public void setAdultVotes(int adultVotes) {
		this.adultVotes = adultVotes;
	}

	public int getOldVotes() {
		return oldVotes;
	}

	public void setOldVotes(int oldVotes) {
		this.oldVotes = oldVotes;
	}

	public void setMoreInfo() {
		setNumberOfVotes();
		setPercentages();
	}

	private void setNumberOfVotes() {
		int years;
		boolean vote;
		for (Vote each : getVotes()) {
			years = AgeCalculator.calculateAge(each.getUser().getBirthday());
			vote = each.isValue();
			if (years >= 18 && years <= 30) {
				if (vote) {
					this.youngNumberYes++;
				} else {
					this.youngNumberNo++;
				}
			} else if (years > 30 && years <= 55) {
				if (vote) {
					this.adultgPerYes++;
				} else {
					this.adultNumberNo++;
				}
			} else if (years > 55) {
				if (vote) {
					this.oldNumberYes++;
				} else {
					this.oldNumberNo++;
				}
			}
		}

	}

	private void setPercentages() {
		if (getTotal() > 0) {

			int totalY = getYoungNumberNo() + getAdultNumberYes();
			int totalA = getAdultNumberNo() + getAdultNumberYes();
			int totalO = getOldNumberYes() + getOldNumberNo();

			this.youngPerYes = getYoungNumberYes() > 0 ? (getYoungNumberYes() / (double) totalY) * 100 : 0;
			this.youngPerNo = getYoungNumberNo() > 0 ? (getYoungNumberNo() / (double) totalY) * 100 : 0;
			this.adultgPerYes = getAdultNumberYes() > 0 ? (getAdultNumberYes() / (double) totalA) * 100 : 0;
			this.adultgPerNo = getAdultNumberNo() > 0 ? (getAdultNumberNo() / (double) totalA) * 100 : 0;
			this.oldPerYes = getOldNumberYes() > 0 ? (getOldNumberYes() / (double) totalO) * 100 : 0;
			this.oldPerNo = getOldNumberNo() > 0 ? (getOldNumberNo() / (double) totalO) * 100 : 0;

			this.youngVotes = (int) (totalY > 0 ? totalY / (double) getTotal() * 100 : 0);
			this.adultVotes = (int) (totalA > 0 ? totalA / (double) getTotal() * 100 : 0);
			this.oldVotes = (int) (totalO > 0 ? totalO / (double) getTotal() * 100 : 0);
		}
	}

	@Override
	public String toString() {
		return "With a participation of " + getTotal()
				+ " we have the next statistics looking to the years of the citizens: \n"
				+ "\t Between 18 and 30 years old: " + "\n\t\tYes-->" + getYoungPerYes() + "%" + "\n\t\tNo-->"
				+ getYoungPerNo() + "%" + "\t Between 30 and 55 years old: " + "\n\t\tYes-->" + getAdultgPerYes() + "%"
				+ "\n\t\tNo-->" + getAdultgPerNo() + "%" + "\t More tha 55 years old: " + "\n\t\tYes-->"
				+ getOldPerYes() + "%" + "\n\t\tNo-->" + getOldPerNo() + "%";

	}

}
