function solution(price, money, count) {
    var amount = 0;
    
    for (let i = 1; i <= count; i++) {
        amount += price * i;
    }

    return amount > money ? amount - money : 0;
}