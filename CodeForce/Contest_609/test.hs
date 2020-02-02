---------------Problem A----------------------


checkComposite :: Int -> Bool
checkComposite n
  | n <= 0
    = True
  | otherwise
    = (not . null) [x | x <- [2..(n - 1)], n `mod` x == 0]

compositeLists :: [Int]
compositeLists = [x | x <- [1..], checkComposite x]

findCompositePairs :: Int -> (Int, Int)
findCompositePairs n
  = head [(n + x, x) | x <- compositeLists, checkComposite (n + x)]

findCompositePairsPrint :: Int -> String
findCompositePairsPrint n
  = show x ++ " " ++ show y
    where
      (x, y) = findCompositePairs n


---------------Problem B----------------------
