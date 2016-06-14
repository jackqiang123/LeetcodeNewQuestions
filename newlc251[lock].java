// Implement an iterator to flatten a 2d vector.
//
// For example, Given 2d vector =
//
// [
//   [1,2],
//   [3],
//   [4,5,6]
// ]
// By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
public class Vector2D implements Iterator<Integer> {
    int listid;
    int elementid;
    List<List<Integer>> data;
    public Vector2D(List<List<Integer>> vec2d) {
      listid = 0;
      elementid = 0;
      data = vec2d;
    }

    @Override
    public Integer next() {
      return data.get(listid).get(elementid++);
    }

    @Override
    public boolean hasNext() {
      while(listid < data.size() && data.get(listid).size() <= elementid) {
        listid++; elementid = 0;
      }
      return listid < data.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
