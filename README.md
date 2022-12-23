# kotlin-jpa-tutorial

### Environment

- kotlin, spring 2.7.6
- docker, mysql
- p6spy logging (test only)

### How to run

1. docker 로 실행되는 local db 세팅을 위한 shell 실행

```shell
> run_db.sh

# 접속 정보 - application-test.yml

url: jdbc:mysql://localhost:3306/kotlin-jpa-tutorial
username: root
password: root
```

2. 테스트 코드 실행
3. db 로 데이터 확인

### Common Background

> 기본 설계 방향은 immutable row 입니다.  
> 영속성 영역의 변화로만 표현하기 위해 도메인 영역의 로직은 단순화 시켰습니다.
>
> version 은 명시적인 비교를 위한 구분자 입니다.  
> 즉 version 이 높은 것만을 추천하는 것은 아닙니다.

- account 와 history 는 1:N 관계 입니다.
    - history 는 accountId 를 알고 있습니다.
- account 는 총 변화량을 알고 있습니다.
- history 는 개별 amount 의 변화량을 알고 있습니다.
- history 에 들어갈 수 있는 amountType 은 `CASH, CARD, GIFT` 3종류 입니다.

## v1

> 부모, 자식 entity 를 각각 영속화시키는 방식

- 객체 관계를 사용하지 않는 가장 기본적인 방식 입니다.
- accountId 를 not-nullable 설정함으로 fk 를 보장할 수 있습니다.
- 코드량이 많아지는 단점이 있습니다.
- entity 관계가 존재하지 않기에 조회시 별도의 dto 를 projection 하는 쿼리가 필요합니다.
    - jpql, querydsl 을 활용합니다.
    - 본 코드에서는 생략하였습니다.
