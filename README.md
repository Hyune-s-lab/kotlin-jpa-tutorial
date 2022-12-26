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

## v2

> 부모 entity 에 OneToMany 단방향 관계 추가

- jpa 를 통한 조회 기능을 활용할 수 있습니다.
- account 는 history 의 aggregate root 가 됩니다.
    - history 생성시 accountId 를 전달받지 않습니다.
- history 는 OneToFew 로 간주하여 EAGER LOADING 을 활용합니다.
    - 업무 요건 상 1개의 account 에는 3개까지의 history 만이 생성될 수 있습니다.
    - 업무 요건 상 account 와 history 는 동시에 필요한 경우가 대부분입니다.
- 하지만 n+1 문제가 있습니다.
    - account 조회 쿼리 1회, 연결된 history 조회 쿼리 3회

## v3

> v2 에서 발생한 n+1 문제를 `fetch join` 으로 해결

- query 성격의 로직에 적용 가능합니다. (cqrs 패턴)
- 샘플 코드는 jpql 을 사용했지만 개인적으로는 querydsl 을 선호합니다.
