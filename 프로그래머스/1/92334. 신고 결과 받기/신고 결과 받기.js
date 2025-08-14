function solution(id_list, report, k) {
    const result = new Array(id_list.length).fill(0);
    
    const map = new Map(id_list.map(item => [item, new Set()]));
    
    for (const r of report) {
        const [from, to] = Array.isArray(r) ? r : r.split(' ');
        map.get(to).add(from);
    }
    
    map.forEach((set, key) => {
      if (set.size >= k) {
        for (const from of set) {
          const i = id_list.indexOf(from);
          result[i] += 1;
        }
      }
    });
    
    return result;
}