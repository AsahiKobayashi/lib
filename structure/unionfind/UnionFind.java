  class UnionFindTree {
    
      private int n ;
      private int groups;
      private int [] parents , size;
  
      UnionFindTree(int n) {
          this.parents=new int[n];
          this.size=new int[n];
          this.groups=n;
          this.n = n ;
          Arrays.fill(size , 1);
          Arrays.setAll(parents,i->i);
      }
  
      public int size(){
          return groups;
      }
  
      public int count(int x){ 
          return size[root(x)] ; 
      }
  
      public boolean same(int x,int y){ 
          return root(x)==root(y) ; 
      }
  
      public int root(int x){
          if(x==parents[x]) return x ;
          else parents[x]=root(parents[x]);
          return parents[x];
      }
  
      public void unite(int l,int r){
          int x = root(l);
          int y = root(r);
          if(x == y) return ;
          if(x < y) {
              int tmp = x;
              x = y ;
              y = tmp;
          }
          int par=x,ch=y;
          groups--;
          size[par] += size[ch];
          parents[ch] = par;
      }
  
      public Map<Integer,List<Integer>> getComponents(){
          Map<Integer,List<Integer>> member = new HashMap<>();
          for(int i = 0 ; i < n ; i ++) {
              int root = root(i);
              member.putIfAbsent(root , new ArrayList<>());
              member.get(root).add(i);
          }
          return member;
      }
  
  }
