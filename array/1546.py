subject = input()
score = list(map(float, input().split()))

maxScore = max(score)

fakeScore = []

for i in score:
    fake = i / maxScore*100
    fakeScore.append(fake)

print(sum(fakeScore) / len(score))
