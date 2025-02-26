# Monoid
## 集合Sに対する単位元 e 、二項演算 op を定義するインターフェイス

### モノイドとは
> 集合Sの任意の元 a ,b, c に対し、以下の条件を満たす構造 <br>
・( a op e ) = ( e op a ) = a　を満たすeが存在する ＊1 <br>
・ op( a , op ( b , c ) ) = op( op ( a , b ) , c ) を満たす演算(op) ＊2 <br>

### e()
> 上記の *1 を定義

### op( a , b )
> 上記の *2 を定義

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
