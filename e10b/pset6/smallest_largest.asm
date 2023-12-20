.data
success_string: .asciiz "program ran successfully!\n"   # success message for debugging
newline:        .asciiz "\n"                            # newline character for pretty printing
smallest_label: .asciiz "smallest int: "                # label for smallest value
largest_label:  .asciiz "largest int: "                 # label for largest value

# Test case 1
# N:              .word   9
# table:          .word   3, -1, 6, 5, 7, -3, -15, 18, 2

# Test case 2
# N:              .word 1
# table:          .word 3

# # Test case 3 (all negative)
# N:              .word   9
# table:          .word   -3, -1, -6, -5, -7, -3, -15, -18, -2

# Test case 4 (all zeros/all matching)
N:             .word 3
table:         .word 0, 0, 0

.text
.globl main

main:
    # Load N into $t0 (array length)
    lw $t0, N

    # Load the address of the first element of the table into $t1
    la $t1, table

    # Load the first element of the table into $t2 and $t3 as smallest and largest placeholders
    lw $t2, 0($t1)
    lw $t3, 0($t1)

    # Loop through the array and find the smallest value
    loop:
    beqz $t0, end_loop   # If N == 0, exit the loop

    # Load the current element into $t4
    lw $t4, 0($t1)

    # Compare the current element ($t4) with the smallest value ($t2)
    slt $t5, $t4, $t2

    # If $t5 is 1 (current element is smaller), update the smallest value ($t2)
    beqz $t5, not_smaller
    move $t2, $t4

    not_smaller:

    # Compare the current element ($t4) with the largest value ($t3)
    slt $t5, $t3, $t4

    # If $t5 is 1 (current element is larger), update the largest value ($t3)
    beqz $t5, not_larger
    move $t3, $t4

    not_larger:

    # Move to the next element in the table
    addi $t1, $t1, 4

    # Decrement loop counter
    addi $t0, $t0, -1

    j loop  # Repeat the loop

    # Exit the loop before printing
    end_loop:

    # Print the "smallest int: " label
    li $v0, 4              # System call code for printing a string
    la $a0, smallest_label  # Load the address of the label into $a0
    syscall

    # Print the smallest value
    li $v0, 1          # System call code for print integer
    move $a0, $t2      # Move the smallest value into $a0
    syscall

    # Print a line break
    li $v0, 4          # System call code for printing a string
    la $a0, newline    # Load the address of the newline character into $a0
    syscall

    # Print the "largest int: " label
    li $v0, 4              # System call code for printing a string
    la $a0, largest_label  # Load the address of the label into $a0
    syscall

    # Print the largest value
    li $v0, 1          # System call code for print integer
    move $a0, $t3      # Move the largest value into $a0
    syscall

    # Print a line break
    li $v0, 4          # System call code for printing a string
    la $a0, newline    # Load the address of the newline character into $a0
    syscall

    # Print the "success!" string
    li $v0, 4          # System call code for printing a string
    la $a0, success_string  # Load the address of the string into $a0
    syscall

    # Exit the program
    li $v0, 10         # System call code for program exit
    syscall
