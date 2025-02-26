# Monoid
## モノイドを定義するインターフェイス

### モノイドとは
> 集合 S とその上の二項演算 • : S × S → S が与えられ、以下の条件 <br>
> #### 結合律
> S の任意の元 a, b, c に対して、(a • b) • c = a • (b • c).
> #### 単位元の存在
> S の元 e が存在して、S の任意の元 a に対して e • a = a • e = a.

### 実装例（加算）
```
class AddMonoid implements Monoid<Integer> {
    @Override
    public Integer e() {
        return 0 ;
    }
    @Override
    public Integer op(Integer a, Integer b) {
        return a + b ;
    }
}
```
