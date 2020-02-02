module Main where

import Data.List.Split
import Data.List


getCommandsA :: String -> [String]
getCommandsA []
  = []
getCommandsA s
  = tail (splitOn "\n" s)

getInts :: String -> [Int]
getInts s
  = map read (splitOn " " s)

answer :: [Int] -> Int
answer (a : b : c : d : _)
  = findDuration a b c d
answer _
  = undefined

findMove :: Int -> Int -> Int
findMove start finish
  | start == finish
    = 0
  | start > finish
    = -1
  | otherwise
    = 1

findDuration :: Int -> Int -> Int -> Int -> Int
findDuration start end station radius
  | start == end
    = 0
  | station - radius < start && start <= station + radius
    = findDuration (start + findMove start end) end station radius
  | otherwise
    = 1 + findDuration (start + findMove start end) end station radius

problemA :: String -> String
problemA s
  = showAnswer (map answer (map getInts (getCommandsA s)))
  where
    showAnswer []
      = []
    showAnswer (x : xs)
      = show x ++ "\n" ++ showAnswer xs

testA :: String
testA = "9\n1 10 7 1 \n3 3 3 0 \n8 2 10 4 \n8 2 10 100 \n-10 20 -17 2 \n-3 2 2 0 \n-3 1 2 0 \n2 3 2 3 \n-1 3 -2 2"

main :: IO ()
main = do
  args <- getArgs
  main' args

  where
    main' :: String -> IO ()
    main' args = do
      putStrLn (problemA str)
    main' _ = putStrLn ("Invalid Operation")
