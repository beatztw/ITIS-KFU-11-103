package leetCodeHW;

class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int len=edges.length;
        int parent[]=new int[len+1];
        for(int i=0;i<=len;i++){
            parent[i]=i;
        }
        int ans[]=new int[2];
        for(int i=0;i<len;i++){
            int parent1 = findParent(edges[i][0],parent);
            int parent2 = findParent(edges[i][1],parent);
            if(parent1 != parent2){
                union(edges[i][0], edges[i][1],parent);
            }else{
                ans[0]=edges[i][0];
                ans[1]=edges[i][1];
            }
        }
        return ans;
    }
    public int findParent(int node, int parent[]){
        if(node == parent[node]){
            return parent[node];
        }
        return parent[node]=findParent(parent[node],parent);
    }
    void union(int x,int v,int[]parent){
        x=findParent(x,parent);
        v=findParent(v,parent);
        if(x != v){
            parent[v]=x;
        }
    }

}

