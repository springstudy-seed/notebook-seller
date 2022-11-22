### 정리할점
- [ ] Entity에 기본 생성자를 설정해주어야 하는 이유
- [ ] OneToMany, ManyToMany를 지양하는 이유
- [ ] Transactional을 쓰면 자동으로 updateQuery가 나가는 이유 -> Dirty Checking(+영속성 컨텍스트)
- [ ] Int가 아니라 Long 타입을 지양하는 이유
- [ ] put, patch HTTP Request
- [ ] URL 명명법
- [ ] 자바 enum 메서드 

### 요구 사항 분석
- [x]  판매상은 젠북을 팔지 맥북을 팔지 선택해야한다.
- [x]  노트북은 일련번호, CPU성능, RAM, 하드 디스크 정보를 담고있다.
- NoteBook domain
- [x]  노트북 정보는 추가될 수 있다. 
- createNotebook(NoteBookDto noteBookDto)
- [ ]  각 지점은 판매 노트북의 재고를 기록하고 관리할 수 있다.
    - [x] 재고가 줄어드는 경우
    - [x] 재고가 늘어나는 경우
    - [ ] 가게가 가지고 있는 노트북의 종류, 재고를 불러 올 수 있다.
- [x]  각 판매 지점은 위치정보와 가게 이름, 가게 주인 정보를 가지고 있다.
- Store domain