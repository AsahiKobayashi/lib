interface Monoid<S> {

    S e();

    S op(S a, S b);

}
