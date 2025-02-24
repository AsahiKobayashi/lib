# Monoid
## 集合Sに対する単位元 e 、二項演算 op を定義するインターフェイス
### op( a , b )
> 集合Sの任意の元 a , b , c に対し ( a op ( b op c ) ) = ( op ( a , b ) op c ) を満たすopを定義
### e()
> 集合Sの任意の元 a に対し　( a op e ) = ( e op a ) を満たすeを定義

## 実装例（加算）
'''
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
'''
