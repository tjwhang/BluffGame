# Game of Bluff

[Try Now] (https://ryugod.com/pages/shared/kotlin/Lu9lqgQkNd.template)

Made a motif on Bluff, a simple psychological board game utilizing dice.


주사위를 이용한 단순한 심리 보드 게임인 블러프를 모티브로 만들었습니다. 

## Rule
At first, both players have 5 dice. Both players role their dice and can only check their own. 
Then, the guessing starts. Player 1 makes the guess first about how many times a number came out. 
Player 2 can see Player 1's guess, and if he thinks it is a false guess, he can call a bluff. 
If Player 2 is correct with the bluff, he wins a round. If he gets it wrong, Player 1 wins a round. 
If Player 2 decided not to call a bluff, the game continues, this time Player 2 gets to guess. 

When a player loses a round, he also loses one dice. 
Then, the next round begins. The last man to have a dice wins the game. 

처음에는 두 플레이어 모두 5개의 주사위를 가지고 있습니다. 두 플레이어 모두 주사위 역할을 하며 자신의 주사위만 확인할 수 있습니다.
그런 다음 추측이 시작됩니다. 플레이어 1은 숫자가 몇 번이나 나왔는지 먼저 추측합니다.
플레이어 2는 플레이어 1의 추측을 볼 수 있으며, 거짓 추측이라고 생각하면 허세라고 부를 수 있습니다.
플레이어 2가 허세를 부리면 라운드에서 승리합니다. 틀리면 플레이어 1이 라운드에서 승리합니다.
플레이어 2가 허세를 부리지 않기로 결정했다면 게임은 계속 진행되며, 이번에는 플레이어 2가 추측할 수 있습니다.

플레이어가 라운드에서 패하면 주사위 한 개도 잃게 됩니다.
그런 다음 다음 라운드가 시작됩니다. 주사위를 가진 마지막 사람이 게임에서 승리합니다.

### Rule displayed in-game
1. Each player starts with 5 dice.
2. Players take turns to make a bid on the quantity of dice with a specific face value.
3. The next player must bid higher than the previous bid.
4. If a player thinks the previous bid is incorrect, they can call bluff.
5. If bluff is called, all dice are revealed. If the bid is correct, the player who made the bid loses a die. If the bid is incorrect, the player who called bluff loses a die.
6. The game continues until only one player has dice left.

## Implementation
I was lazy so I first told Bing Copilot AI to code the basics, but it was horrible. 
I refined it to satisfy our needs. 

저는 게으르기 때문에 먼저 빙 코파일럿 AI에게 기본을 코딩하라고 말했지만 끔찍했습니다.
저희의 요구를 충족하기 위해 개선했습니다.

## Note
This game was made for my friend in the board game club at my school. 
However, I have future plans to include this game in a mega console minigame pack or something. 

이 게임은 학교 보드게임 동아리에 있는 친구를 위해 만들어졌습니다.
하지만 향후 이 게임을 메가 콘솔 미니게임 팩 등에 포함시킬 계획이 있습니다.

한글은 다시 쓰기 귀찮았기에 번역기를 사용했습니다. 이해 했음 됐져
