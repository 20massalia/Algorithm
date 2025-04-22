function solution(survey, choices) {
    const scores = {
        R: 0, T: 0,
        C: 0, F: 0,
        J: 0, M: 0,
        A: 0, N: 0
    };

    for (let i = 0; i < survey.length; i++) {
        const [left, right] = survey[i];
        const choice = choices[i];

        if (choice < 4)
            scores[left] += 4 - choice;
        else if (choice > 4)
            scores[right] += choice - 4;
    }

    let result = '';
    result += scores["R"] >= scores["T"] ? "R" : "T";
    result += scores["C"] >= scores["F"] ? "C" : "F";
    result += scores["J"] >= scores["M"] ? "J" : "M";
    result += scores["A"] >= scores["N"] ? "A" : "N";

    return result;
}
