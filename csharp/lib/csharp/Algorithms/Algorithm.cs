/*
 *  This file is part of OpenStaticAnalyzer.
 *
 *  Copyright (c) 2004-2017 Department of Software Engineering - University of Szeged
 *
 *  Licensed under Version 1.2 of the EUPL (the "Licence");
 *
 *  You may not use this work except in compliance with the Licence.
 *
 *  You may obtain a copy of the Licence in the LICENSE file or at:
 *
 *  https://joinup.ec.europa.eu/software/page/eupl
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the Licence is distributed on an "AS IS" basis,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the Licence for the specific language governing permissions and
 *  limitations under the Licence.
 */

    using System;
    using System.Text;

namespace Columbus.Csharp.Asg.Algorithms {
    
    /// <summary>
    /// Common base class for all algorithm classes.
    /// </summary>
#if (CSHARP_INTERNAL)
    internal
#else
    public
#endif
    class Algorithm : Visitors.Visitor {

        /// <summary>
        /// Increases the depth of the given visitor.
        /// </summary>
        /// <param name="visitor">[in] The visitor class.</param>
        protected void incVisitorDepth(Visitors.Visitor visitor) {
            visitor.incDepth();
        }

        /// <summary>
        /// Decreases the depth of the given visitor.
        /// </summary>
        /// <param name="visitor">[in] The visitor class.</param>
        protected void decVisitorDepth(Visitors.Visitor visitor) {
            visitor.decDepth();
        }

    }

}