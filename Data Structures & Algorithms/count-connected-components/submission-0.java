class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        // 1. Iterate through the edges, not the nodes
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        // 2. Return the tracked component count
        return uf.getComponents();
    }
}

class UnionFind {
    private int[] parent;
    private int components; // Track components dynamically

    public UnionFind(int n) {
        parent = new int[n];
        components = n; // Initially, every node is its own disconnected component

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // Connects two nodes by connecting their roots
    public void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        // If they have different roots, they belong to different components.
        // Merge them and decrement the total component count.
        if (root1 != root2) {
            parent[root1] = root2; 
            components--; 
        }
    }

    // Finds the root of a node
    public int find(int node) {
        int root = node;
        while (root != parent[root]) {
            root = parent[root];
        }
        return root;
    }

    public int getComponents() {
        return components;
    }
}