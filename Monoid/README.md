# Monoid
## 集合Sに対する単位元 e 、二項演算 op を定義するインターフェイス

### e()
> 集合Sの任意の元 a に対し　( a op e ) = ( e op a ) = a を満たすeを定義　＊1

### op( a , b )
> 集合Sの任意の元 a , b , c に対し op( a , op ( b , c ) ) = op( op ( a , b ) , c ) を満たすopを定義　＊2

### 具体例

集合　S = ( 1 、　3 、　5 ) を考える。　<br>
以下の場合条件を満たす 
e = 0 、op = ×
・ ( 3 × 1 ) = ( 1 × 3 ) = 3 ＊1
・ ( 1 × ( 3 × 5 ) ) = ( ( 1 × 3 ) × 5 ) ＊2

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
