# TreeMultiSet (順序付き多重集合)
> ### コンストラクタ
|コンストラクタ|説明|計算量|
|:---:|:---:|:---:|
|**`TreeMultiSet()`**|親クラスにTreeMapを渡します。|O ( 1 )|
|**`TreeMultiSet(Comparator<? super E> comparator)`**|順序を設定します。|O ( 1 )|
> ### メソッド
|修飾子|戻り値の型|メソッド|説明|計算量|
|:---:|:---:|:---|:---|:---:|
|`public`|`E`|**`peekFirst() `**|最も優先度の高い要素を取得します。|O ( logN)|
|`public`|`E`|**`peekLast()`**|最も優先度の低い要素を取得します。|O ( logN)|
|`public`|`E`|**`pollFirst()`**|最も優先度の高い要素を取得、削除します。|O ( logN)|
|`public`|`E`|**`pollLast()`**|最も優先度の低い要素を取得、削除します。|O ( logN)|
|`public`|`E`|**`pollFirst(long amount)`**|最も優先度の高い要素を指定した個数取得、削除します。|O ( logN)|
|`public`|`E`|**`pollLast(long amount)`**|最も優先度の低い要素を指定した個数取得、削除します。|O ( logN)|
|`public`|`E`|**`ceilingKey(E e)`**|変数e以上の値を取得します。存在しない場合、nullを返します。|O ( logN)|
|`public`|`E`|**`higherKey(E e)`**|変数eより大きい値を取得します。存在しない場合、nullを返します。|O ( logN)|
|`public`|`E`|**`floorKey(E e)`**|変数e以下の値を取得します。存在しない場合、nullを返します。|O ( logN)|
|`public`|`E`|**`lowerKey(E e)`**|変数eより小さい値を取得します。存在しない場合、nullを返します。|O ( logN)|
