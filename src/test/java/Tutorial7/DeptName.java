package Tutorial7;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeptName {

	@JsonProperty("dname")
	private String dname;
	
	@JsonProperty("projectManager")
	private String projectManager;
	
	@JsonProperty("teamLeader")
	private String teamLeader;

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}

	@Override
	public String toString() {
		return "DeptName [dname=" + dname + ", projectManager=" + projectManager + ", teamLeader=" + teamLeader + "]";
	}

	
	
	
	
	
}
