import Data.List.Split
import Data.List

----------------Problem A----------------------
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



-- ------------ProblemB1------------------------------
getCommandsB :: String -> [String]
getCommandsB []
  = []
getCommandsB s
  = tail (splitOn "\n" s)

getIntsB :: [String] -> [(Int, [Int])]
getIntsB []
  = []
getIntsB (s1 : s2 : strs)
  = ((getInts s1) !! 1, getInts s2) : getIntsB s2

maxGifts :: Int -> [Int] -> Int
maxGifts coins giftPrices
  = findMaxGifts (sort (filter (<= coins) giftPrices))
  where
    findMaxGifts :: [Int] -> Int
    findMaxGifts prices@(a1 : a2 : _)
      | a2 <= coins
        = 2 + maxGifts (coins - a2) (drop 2 prices)
    findMaxGifts (a1 : _)
      | a1 <= coins
        = 1
    findMaxGifts _
        = 0

problemB :: Int -> Int -> Int -> [Int] -> Int
problemB n p k prices
  = maxGifts p prices

problemBMain :: String -> String
problemBMain s
  = head (concatMap getAns ((getInts . getCommandsB) s))
  where
    getAns (coins, items)
      = maxGifts coins items
------------ProblemC------------------------------


-- maxPoints :: Int -> Int -> Int -> Int -> [Int] -> [Int] -> Int
-- maxPoints noQuests time a b qs manTime
--   = findMaxPoints time (zip ((questionTime a b qs) manTime))
--
-- findMaxPoints :: Int -> [(Int , Int)] -> Int
--   =
--
-- questionTime :: Int -> Int -> [Int] -> [Int]
-- questionTime a b (q : qs)
--   | q == 0
--     = a : questionTime qs
--   | otherwise
--     = b : questionTime qs
