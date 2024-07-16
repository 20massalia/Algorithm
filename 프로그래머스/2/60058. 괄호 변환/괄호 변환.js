function solution(p) {
    if (!p) return ""
    let [u, v] = ["", ""]
    let [open, close] = [0, 0]
    
    for (let i = 0; i < p.length; i += 1) {
        p[i] === `(` ? ++open : ++close;
        u += p[i];
        if (open === close) {
            v = p.slice(i + 1, p.length);
            break;
        }
    }
    
    if (u[u.length - 1] === `)`) 
        return u + solution(v);
    else {
        u = u.slice(1, u.length - 1).split("");
        for (let i = 0; i < u.length; i += 1) {
            u[i] = u[i] === `)` ? `(` : `)`;
        }
        return "(" + solution(v) + ")" + u.join("");
    }
}