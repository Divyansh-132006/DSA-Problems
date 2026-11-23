class ProductOfNumbers {
    List<Integer> pro;
    public ProductOfNumbers() {
        pro = new ArrayList<>();
        pro.add(1);
    }
    public void add(int num) {
        if (num == 0) {
            pro.clear();
            pro.add(1);
        } else {
            int last = pro.get(pro.size() - 1);
            pro.add(last * num);
        }
    }
    public int getProduct(int k) {
        int n = pro.size();
        if (k >= n) {
            return 0;
        }
        return pro.get(n - 1)/pro.get(n - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */