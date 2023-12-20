.data
begin_message: .asciiz "🚨 "
end_message: .asciiz " is a perfect number! 🚨\n"

.text
.globl main

main:
    li $t0, 5
    li $t1, 500

number_loop:
    blt $t0, $t1, check_number
    j end_program

check_number:
    move $t2, $t0
    li $t3, 0
    li $t4, 1

divisor_loop:
    blt $t4, $t2, check_divisor
    beq $t3, $t0, print_number
    addi $t0, $t0, 1
    j number_loop

check_divisor:
    div $t2, $t4
    mfhi $t5
    beqz $t5, sum_divisor
    addi $t4, $t4, 1
    j divisor_loop

sum_divisor:
    add $t3, $t3, $t4
    addi $t4, $t4, 1
    j divisor_loop

print_number:
    li $v0, 4
    la $a0, begin_message
    syscall
    li $v0, 1
    move $a0, $t0
    syscall
    li $v0, 4
    la $a0, end_message
    syscall
    addi $t0, $t0, 1
    j number_loop

end_program:
    li $v0, 10
    syscall
