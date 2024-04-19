--12_GroupFuction.sql

--테이블내의 하나의 필드값을 전체로 하는 함수

select sum(inprice)as "입고가격합계" from booklist;

select sum(outprice) as"대여가격합계" from booklist where inprice >=18000;


--갯수(count)
select count(*)as "회원수" from memberlist;
select count(*)as "회원수" from memberlist where bpoint <=100;

--평균(average/avg)
select round(avg(inprice),0) as "입고가격평균" from booklist ;
--to_char로 변경된 숫자는 문자로 변경된 것이므로 이제 숫자로써의 기능은 상실. 다른 숫자계산 불가
SELECT to_char(avg(inprice), '999,999,999')as"입고가격평균" from booklist;

--max :최대값
--sequence에 의해서 방금 추가된 자동 증가번호를 조회할때 많이 사용
select max(inprice)from booklist;

--min : 최소값
select min(inprice)from booklist;


--group by
--그룹함수의 결과들을 다른 필드의 그룹으로 재구성
select count(*) as "총대여건수"from rentlist;

--도서별 대여건수
select bnum as "도서번호",count(*)as"도서별 대여건수" from RENTLIST group by bnum;

--rentlist테이블에서 대여일자 (rentdate)별 대여건수와 할인금액 평균
select rentdate as 대여일자, count(*)as 대여건수
from rentlist group by rentdate order by rentdate desc



--having
--그룹핑된 내용들에 조건을 붙일때
select rentdate as 대여일자, count(*) as 대여건수, avg(discount) as 할인금액평균
from rentlist
group by rentdate
having avg(discount)>=150
order by rentdate desc;























