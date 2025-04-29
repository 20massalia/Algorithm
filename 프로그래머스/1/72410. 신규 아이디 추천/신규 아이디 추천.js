function solution(new_id) {
    let id = new_id
        .toLowerCase() // 1단계
        .replace(/[~!@#$%^&*()=+\[\]{}:?,<>\/]/g, "") // 2단계
        .replace(/\.{2,}/g, ".") // 3단계
        .replace(/^\.|\.$/g, ""); // 4단계

    if (id === "") id = "a"; // 5단계

    if (id.length >= 16) // 6단계
        id = id.slice(0, 15).replace(/\.$/, "");

    while (id.length < 3) // 7단계
        id += id[id.length - 1];

    return id;
}
