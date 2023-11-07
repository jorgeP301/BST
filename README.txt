Jorge Mariano Patino jmp17450@uga.edu 811890131

    compilaiton and running instructions there is a compile script with the name compile.sh
    that runs at the command ./compile.sh and you have to edit the file to change the type of input you want to use.
    It is currently set to use the int-input.txt file.

    get single parent explanation:
    the complexity of this method is defined by the reccurence relation T(n) = 2T(n/2) + 1 which when the master theorem applies gives the complexity of O(n).
    the steps this method takes is by starting off by making sure the node is never nullt oavoid null pointer exceptions. our recursive case is if we have a node that has either 2 children or no children, if that is the case then we recur to the right and to the left. the base case is reached when we find a node where there is only one child(right or left) and the nodes info is printed resursively as a list(not the object, just consecutively)

    getNumLeafNodes explanation:
    the worst case complexity of this mehtod is defined by the recurrence relation T(n) = 2T(n/2) + 1
    and when the master theorem is applied the third case where a > b^d applies so the complexity is O(n^log_2 (2)) oe O(n)

    the steps that this method goes through is by initializing a counter at 0 and if both right and left nodes from the start are not null, we recur to the right and left and add them all into the counter variable
    if we reach a node where we have no children we have reached a leaf node and we can return 1 to add to the counter. this goes all the way until no more nodes are found that are leaf nodes

    getcousin explanation:
    the steps that this mehtod goes thorugh is by first checking if the node we want to find cousins for is not int he first or second level(root or next from the root) becuase these nodes will by default not have cousisns, then we we recur if we until we find the parent of the node we use as input. once we find the parent as the next node to travese we go the opposite direction to then use the helper method to print the children of the other parent which gives us the cousins

    the complexity is also O(n) since the worst case compelxity recurrence rrelation is T(n) = 2T(n/2) + 1 and as shown above the master theorem confirms the complexity of o(n)
