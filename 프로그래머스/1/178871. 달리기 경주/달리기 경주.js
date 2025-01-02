function solution(players, callings) {
    const playerMap = new Map();
    
    players.forEach((player, index) => {
        playerMap.set(player, index);
    });
    
    for (const calling of callings) {
        const currentIdx = playerMap.get(calling);
        const prevIdx = currentIdx - 1;
        const prevPlayer = players[prevIdx];
        
        [players[prevIdx], players[currentIdx]] = [players[currentIdx], players[prevIdx]];
        
        playerMap.set(calling, prevIdx);
        playerMap.set(prevPlayer, currentIdx);
    }
    
    return players;
}