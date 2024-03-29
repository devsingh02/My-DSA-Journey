func solveSudoku(board [][]byte)  {//Just use backtracking method to get the right answer
    var result [9][9]byte
    find(0,0,&board,&result)
    for kk:=0;kk<9;kk++{
        for kkk:=0;kkk<9;kkk++{
        (board)[kk][kkk]=(result)[kk][kkk]
        }
    }
}

func find(i int, j int, board *[][]byte,result *[9][9]byte){
    if (*board)[i][j]=='.'{
        for k:=0;k<9;k++{
            zz:=byte('1'+k)
            if this_ok(zz,i,j,board){
                (*board)[i][j]=zz
                if j<len((*board)[0])-1{
					find(i,j+1,board,result)
                }else if i<len(*board)-1{
					find(i+1,0,board,result)
                }else{
                    break
                }
                (*board)[i][j]='.'
            }
        }
    }else{
        if j<len((*board)[0])-1{
                find(i,j+1,board,result)
        }else if i<len(*board)-1{
                find(i+1,0,board,result)
        }  
    }
    if i==8&&j==8{
        for kk:=0;kk<9;kk++{
            for kkk:=0;kkk<9;kkk++{
                (*result)[kk][kkk]=(*board)[kk][kkk]
            }
        }
    }
}

func this_ok(zz byte,i int,j int, board *[][]byte)bool{
    for m:=0;m<9;m++{
        if (*board)[i][m]==zz{
            return false
        }
        if (*board)[m][j]==zz{
            return false
        }
    }
    x:=i/3
    y:=j/3
    for m:=x*3;m<x*3+3;m++{
        for n:=y*3;n<y*3+3;n++{
            if (*board)[m][n]==zz{
                return false
            }
        }
    }
    return true
}