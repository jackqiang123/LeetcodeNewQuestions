// Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
//
// Note:
// If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
// All airports are represented by three capital letters (IATA code).
// You may assume all tickets form at least one valid itinerary.
// Example 1:
// tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
// Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
// Example 2:
// tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
// Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
// Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
//
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
			Map<String, List<String>> map = new HashMap<>();
			for (String[] ticket : tickets){
				String dep = ticket[0];
				String dest =  ticket[1];
				if (map.get(dep) == null) map.put(dep, new ArrayList<String>());
				map.get(dep).add(dest);
				Collections.sort(map.get(dep));
			}
			return dfs("JFK", map);
    }
		private List<String> dfs(String dep, Map<String, List<String>> map){
			List<String> res = new ArrayList<>();
			while(map.get(dep) != null && map.get(dep).size() != 0){
				String next = map.get(dep).remove(0);
				res.addAll(0, dfs(next, map));
			}
			res.add(0, dep);
			return res;
		}
}
