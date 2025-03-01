# MultiSet (  多重集合 )

## 詳細

> ### コンストラクタ
|コンストラクタ|説明|計算量|
|:---:|:---|:---:|
|**`MultiSet()`**|コンストラクタの呼び出し先にHashMapを渡します。|O ( 1 )|
|**`MultiSet(Map<E , Long> map)`**|Mapの型を決めます。|O ( 1 )|
> ### フィールド
|修飾子|型|フィールド|説明|
|:---:|:---:|:---:|:---|
|`protected`|`long`|**`size`**|要素の個数を管理します。|
|`protected`|`Map<E , Long>`|**`map`**|値、個数を管理します。|
> ### メソッド
|修飾子|戻り値の型|メソッド|説明|計算量|
|:---:|:---:|:---|:---|:---:|
|`public`|`long`|**`size(boolean u)`**|変数uが真の場合、**要素の種類数**を返します。<br> 偽の場合、**要素の個数**を返します  |O ( 1 )|
|`public`|`long`|**`size(E e)`**|含まれる変数eの個数を返します。|O ( 1 )|
|`public`|`void`|**`add(E e)`**|変数eを追加します。|O ( 1 )|
|`public`|`void`|**`add(E e,long amount)`**|変数eを指定した個数分、追加します。|O ( 1 )|
|`public`|`void`|**`remove(E e)`**|変数eを削除します。|O ( 1 )|
|`public`|`void`|**`remove(E e,long amount)`**|変数eを指定した個数分、削除します。|O ( 1 )|
|`public`|`boolean`|**`contains(E e)`**|変数eが含まれるか返します。|O ( 1 )|
|`public`|`Set<E>`|**`keySet()`**|Setを返します。|O ( N )|
