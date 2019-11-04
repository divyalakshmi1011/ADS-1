class Solution {
	public Team[] sort(Team[] teams) {
		// your code goes here
		int n = teams.length;
        for(int i = 1; i < n; i++) {
            for(int j = i; j > 0; j--) {
                if(teams[j].compareTo(teams[j-1]) == 1) {
                    Team temp = teams[j];
                    teams[j] = teams[j-1];
                    teams[j-1] = temp;
                } else {
                    break;
                }
            }
        }
		return teams;
	}
}
class Team implements Comparable<Team> {
	String teamName;
	int noOfWins;
	int noOfLosses;
	int noOfDraws;
	Team(String name, int wins, int losses, int draws){
		teamName = name;
		noOfDraws = draws;
		noOfWins = wins;
		noOfLosses = losses;
	}
	public String toString() {
		//retrun all the attributes as a string but appending with ", "
        return "Name " + teamName + " , noOfWins " + noOfWins + " , noOfLosses " + noOfLosses + " , noOfDraws " + noOfDraws;
	}
	public int compareTo(Team that) {
        if (this.noOfWins > that.noOfWins) {
            return 1;
        }else if (this.noOfWins < that.noOfWins) {
            return -1;
        }else {
            if (this.noOfLosses < that.noOfLosses) {
                return 1;
            }else if (this.noOfLosses > that.noOfLosses) {
                return -1;
            } else {
                if (this.noOfDraws > that.noOfDraws) {
                    return 1;
                }else {
                    return -1;
                }
            }

		}
	}
}
