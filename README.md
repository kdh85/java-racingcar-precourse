# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)


##기능목록
* 이동거리의 기본값은 0이다. 생성될때 기본값 미만인 경우 에러가 발생한다.
* 한번 이동하는 단위 값은 1이다. 이동을 시키면 거리단위 1만큼 이동이 된다.
* 차량이름이 있다.
* 이름은 5글자 이하까지 가능하다.
* 동일한 차량이름을 사용할 수 없다.
* 차는 이동거리와 이름을 가진다.
* 차가 기본생성될때는 이동거리 0을 가진다.
* 차는 거리에게 이동하라는 메세지를 전달한다.
* 이동하라는 메세지 전달에는 입력받은 숫자가 4이상일때라는 조건이 붙는다. 
* 차콜랙션은 각 차들의 모음이다.
* 각 차량별로 이동관련 판별값과 이름을 전달한다.
* 차콜랙션은 각 차별로 자신의 이동거리를 메세지를 통해서 가져온 뒤 비교할 수 있다.
* 비교할때 동률의 상황이 발생할 수 있다.
* 차콜랙션에서 비교하여 가장 먼 이동거리의 차량의 이름들을 반환 한다.